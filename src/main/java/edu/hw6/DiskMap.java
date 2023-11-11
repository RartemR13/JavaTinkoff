package edu.hw6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public class DiskMap implements Map<String, String> {

    DiskMap(Path dirPath) throws IOException {
        if (!Files.isDirectory(dirPath)) {
            Files.createDirectory(dirPath);
        }

        dir = dirPath;

        storage = new ArrayList<>();

        Stream<Path> listPairs = Files.list(dirPath);
        StringBuilder value = new StringBuilder();
        listPairs.forEach((Path filePath) -> {
            Stream<String> lines = null;
            try {
                lines = Files.lines(filePath, StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            lines.forEach(value::append);
            lines.close();

            storage.add(new AbstractMap.SimpleEntry<>(filePath.getFileName().toString(), value.toString()));
        });
        listPairs.close();
    }

    public int size() {
        return storage.size();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }

        for (var enrtyPair : storage) {
            if (enrtyPair.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsValue(Object value) {
        if (value == null) {
            return false;
        }

        for (var entryPair : storage) {
            if (entryPair.getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    public String get(Object key) {
        for (var entryPair : storage) {
            if (entryPair.getKey().equals(key)) {
                return entryPair.getValue();
            }
        }

        return null;
    }

    public String put(String key, String value) {
        if (containsKey(key)) {
            String ret = remove(key);
            put(key, value);
            return ret;
        }

        storage.add(new AbstractMap.SimpleEntry<>(key, value));

        try {
            Path newFile = Path.of(dir.toString(), key);
            Files.createFile(newFile);

            PrintWriter pw = new PrintWriter(newFile.toString());
            pw.print(value);
            pw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public String remove(Object key) {
        Path deleteFile = Path.of(dir.toString(), key.toString());
        try {
            Files.deleteIfExists(deleteFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < storage.size(); ++i) {
            if (storage.get(i).getKey().equals(key)) {
                return storage.remove(i).getValue();
            }
        }

        return null;
    }

    public void putAll(Map<? extends String, ? extends String> m) {
        m.forEach((String key, String value) -> put(key, value));
    }

    @NotNull
    public Set<String> keySet() {
        Set<String> res = new HashSet<>();

        for (var entryPair : storage) {
            res.add(entryPair.getKey());
        }

        return res;
    }

    @NotNull
    public Collection<String> values() {
        ArrayList<String> res = new ArrayList<>();

        for (var entryPair : storage) {
            res.add(entryPair.getValue());
        }

        return res;
    }

    @NotNull
    public Set<Map.Entry<String, String>> entrySet() {
        return new HashSet<>(storage);
    }

    public void clear() {
        while (!isEmpty()) {
            remove(0);
        }
    }

    private final ArrayList<AbstractMap.SimpleEntry<String, String>> storage;
    Path dir;
}
