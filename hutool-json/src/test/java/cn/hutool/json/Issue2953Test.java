package cn.hutool.json;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Issue2953Test {
	@Test
	public void parseObjWithBigNumberTest() {
		final String a = "{\"a\": 114793903847679990000000000000000000000}";
		final JSONObject jsonObject = JSONUtil.parseObj(a, JSONConfig.create());
		assertEquals("{\"a\":\"114793903847679990000000000000000000000\"}", jsonObject.toString());
	}
}
