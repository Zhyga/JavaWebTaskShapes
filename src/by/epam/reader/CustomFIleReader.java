package by.epam.reader;

import by.epam.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFIleReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readText(String fileName) throws CustomException {
        Path path = Paths.get(fileName);
        try (Stream<String> linedTextStream = Files.lines(path)) {
            List<String> linedTextList = linedTextStream.collect(Collectors.toList());
            logger.info("There were read {} lines from file", linedTextList.size());
            return linedTextList;
        } catch (IOException e) {
            logger.error("File is not exists", e);
            throw new CustomException("File is not exists", e);
        }
    }
}
