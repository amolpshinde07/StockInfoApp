package com.stockinfo.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stockinfo.services.IFileReader;

/**
 * @author amol.shinde
 *
 */
public class TextFileReaderImpl implements IFileReader{
	private String inputFile;
	public TextFileReaderImpl(String inputFile) {
		this.setInputFile(inputFile);
	}
	@Override
	public List<String> getListOfSymbolsFromFile() {
		try {
			Stream <String> lines = Files.lines(Paths.get(getInputFile()));
			List<String> collect = lines.collect(Collectors.toList());
			lines.close();
			return collect;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getInputFile() {
		return inputFile;
	}
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

}
