package edu.hw6;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DiskMapTest {
    private static @NotNull ArrayList<String> entryFiles(Path dir) throws IOException {
        ArrayList<String> ret = new ArrayList<>();
        try (Stream<Path> dirStream = Files.list(dir)) {
            dirStream.forEach((Path curPath) -> ret.add(curPath.getFileName().toString()));
        }

        return ret;
    }

    private static void deleteOneLvlDir(Path dir) throws IOException {
        var entry = entryFiles(dir);

        for (String file : entry) {
            Files.deleteIfExists(Path.of(dir.toString(), file));
        }

        Files.delete(dir);
    }

    @Test
    @DisplayName("Тест на мапу")
    void mapTest() throws IOException {
        Map<String, String> m = null;

        try {
            m = new DiskMap(Path.of("foo"));
        } catch (IOException any) {
            fail();
        }

        m.put("яблоко", "apple");

        try {
            assertThat(m.get("яблоко")).isEqualTo("apple");
            assertNull(m.get("тыблоко"));
        } finally {
            deleteOneLvlDir(Path.of("foo"));
        }
    }

    @Test
    @DisplayName("Дописываение")
    void addTest() throws IOException {
        DiskMap toWrite = new DiskMap(Path.of("foo"));
        toWrite.put("C", "D");

        DiskMap toCheck = new DiskMap(Path.of("foo"));

        try {
            assertThat(toCheck.get("C")).isEqualTo("D");
        } finally {
            deleteOneLvlDir(Path.of("foo"));
        }
    }
}
