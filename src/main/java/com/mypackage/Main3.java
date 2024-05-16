package com.mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class Main3 {

    static final List<String> patternList = List.of("demo", "demo2");

    public static void main(String[] args) throws IOException {
        Path synthGenerateDocumentDir = Files.createTempDirectory("synth-generate-document");
        Path patternsDir = Files.createDirectory(Path.of(synthGenerateDocumentDir+ "/pattern"));
        Path generatedDir = Files.createDirectory(Path.of(synthGenerateDocumentDir + "/generated"));
        Path synthPath = Files.createFile(Path.of(synthGenerateDocumentDir + "/synth"));

        copySynthToTempDir(synthPath);
        copyPatternsToTempDir(patternsDir);

        generate(synthPath, patternsDir);
    }

    public static void copySynthToTempDir(Path synthPath) throws IOException {
        InputStream synthResourceStream = Main3.class.getResourceAsStream("/main/resources/synth");
        Files.copy(synthResourceStream, synthPath, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyPatternsToTempDir(Path patternsDir) throws IOException {
        for (String pattern : patternList) {
            Path patternDirPath = Path.of(patternsDir + "/" + pattern);
            Files.createDirectory(patternDirPath);
            Files.createFile(Path.of(patternDirPath + "/demo.json"));
            InputStream patternStream = Main3.class.getResourceAsStream("/main/resources/pattern/" + pattern + "/demo.json");
            Files.copy(patternStream, Path.of(patternDirPath + "/demo.json"), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static void generate(Path synth, Path patternDir) throws IOException {
        for (String patternName : patternList) {
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c", "chmod a+x " + synth + ";" + synth + " generate --random --size 10 " + patternDir + "/" + patternName);
            processBuilder.redirectErrorStream(true);
            Process start = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
