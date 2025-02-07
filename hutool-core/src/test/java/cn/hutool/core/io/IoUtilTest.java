package cn.hutool.core.io;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IoUtilTest {

	@Test
	public void readBytesTest() {
		final byte[] bytes = IoUtil.readBytes(ResourceUtil.getStream("hutool.jpg"));
		assertEquals(22807, bytes.length);
	}

	@Test
	public void readBytesWithLengthTest() {
		// 读取固定长度
		final int limit = RandomUtil.randomInt(22807);
		final byte[] bytes = IoUtil.readBytes(ResourceUtil.getStream("hutool.jpg"), limit);
		assertEquals(limit, bytes.length);
	}

	@Test
	public void readLinesTest() {
		try (BufferedReader reader = ResourceUtil.getUtf8Reader("test_lines.csv");) {
			IoUtil.readLines(reader, (LineHandler) Assertions::assertNotNull);
		} catch (IOException e) {
			throw new IORuntimeException(e);
		}
	}
}
