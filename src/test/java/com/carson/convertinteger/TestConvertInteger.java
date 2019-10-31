package com.carson.convertinteger;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class TestConvertInteger {

	@Test
	public void test1() {
		Integer[] intput = {2,3};
		List<String> output = ConvertInteger.convert(intput);
		List<String> list = Arrays.asList(new String[]{"ad","ae","af","bd","be","bf","cd","ce","cf"});
		Assert.assertTrue(list.size()==output.size()&&list.containsAll(output));
	}

	@Test
	public void test2() {
		Integer[] intput = {9};
		List<String> output = ConvertInteger.convert(intput);
		List<String> list = Arrays.asList(new String[]{"w","x","y","z"});
		Assert.assertTrue(list.size()==output.size()&&list.containsAll(output));
	}

	@Test
	public void test3() {
		Integer[] intput = {23};
		List<String> output = ConvertInteger.convert(intput);
		List<String> list = Arrays.asList(new String[]{"ad","ae","af","bd","be","bf","cd","ce","cf"});
		Assert.assertTrue(list.size()==output.size()&&list.containsAll(output));
	}

}
