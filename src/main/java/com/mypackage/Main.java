//package com.mypackage;
//
//import java.io.*;
//import java.net.URL;
//import java.nio.file.DirectoryStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//import java.util.Enumeration;
//import java.util.jar.JarEntry;
//import java.util.jar.JarFile;
//
//public class Main {
//    public static void main(String[] args) throws IOException, InterruptedException {
////        ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "ls -l");
////        InputStream inputStream = Main.class.getResourceAsStream("/main/resources/synth");
////        Process start = processBuilder.start();
//
//            // Получение доступа к утилите из JAR-файла
//            InputStream inputStream = Main.class.getResourceAsStream("/main/resources/synth");
//            InputStream patternStream = Main.class.getResourceAsStream("/main/pattern/demo/");
//
//            // Создание временного файла для утилиты
//            File tempSynth = File.createTempFile("synth", "");
//            File tempPattern = File.createTempFile("synth", "");
////            File tempFile = File.createTempFile("synth", "");
//            tempSynth.deleteOnExit();
//
//        // Копирование утилиты из JAR-файла во временный файл
//            Files.copy(inputStream, tempSynth.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Path tempPatternFile = createTempPatternFile();
//
//            // Запуск утилиты с помощью ProcessBuilder
//            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c", "chmod a+x " + tempSynth.getPath() + ";" + tempSynth.getPath() + " generate --random --size 10 " + tempPatternFile.getParent());
//            processBuilder.redirectErrorStream(true);
//            Process process = processBuilder.start();
//
//            // Обработка вывода или ошибок, если необходимо
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            try (DirectoryStream<Path> entries = Files.newDirectoryStream(path)) {
//                    for (Path entry : entries) {
//                            System.out.println(entry);
//                    }
//            }
//
//            tempSynth.delete();
////        BufferedReader in = new BufferedReader(new InputStreamReader(start.getInputStream()));
////        String line;
////        while ((line = in.readLine()) != null) {src/main/resources/pattern/demo
////            System.out.println(line);
////        }
//
/////home/ruslan/IdeaProjects/test_synth/target/classes/main/resources/synth generate --random --size 10 src/main/resources/pattern/demo
//
//
//
//    }
//
//
//        public static Path createTempPatternFile() throws IOException {
//                // Создание временной директории
//                Path tempDir = Files.createTempDirectory("pattern");
//                Path tempDemo = Files.createTempDirectory(tempDir, "demo");
//                Path tempFile = Files.createTempFile(tempDemo, "demo", ".json");
//
//                String resourcePath = "pattern/demo/demo.json";
//
//                JarFile jarFile = new JarFile("/home/ruslan/IdeaProjects/test_synth/target/Just_project_with_synth-1.0-SNAPSHOT.jar");
//                Enumeration<JarEntry> entries = jarFile.entries();
//                while (entries.hasMoreElements()) {
//                        JarEntry entry = entries.nextElement();
//                        String entryName = entry.getName();
//
//                        if (entryName.equals(resourcePath)) {
//                                // Создание пути к файлу во временной директории
////                        Path tempFile = tempDir.resolve(entryName.substring(resourcePath.length()));
////                        Files.createDirectories(tempFile.getParent());
//
//                                // Копирование файла из JAR во временную директорию
//                                try (InputStream in = jarFile.getInputStream(entry)) {
//                                        Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
//                                }
//                        }
//                }
//                return tempFile;
//        }
//
//        public void generate() {
//
//        }
//}
//
