/**
 * 
 *//*

package io.bauer.benchmark;

import java.io.IOException;
import java.util.List;

import com.jsoniter.DecodingMode;
import com.jsoniter.JsonIterator;
import com.jsoniter.annotation.JsoniterAnnotationSupport;
import com.jsoniter.output.EncodingMode;
import com.jsoniter.output.JsonStream;
import com.jsoniter.spi.TypeLiteral;

import io.bauer.benchmark.models.User;

*/
/**
 * @author jbauer
 *//*

public class JsoniterBenchmark extends Benchmark
{
	final static TypeLiteral<List<User>> userListType = new TypeLiteral<List<User>>()
	{
	};

	public JsoniterBenchmark()
	{
		this.setup();
	}

	@Override
	public void setup()
	{
		super.setup();
		JsonIterator.setMode(DecodingMode.DYNAMIC_MODE_AND_MATCH_FIELD_WITH_HASH);
		JsonStream.setMode(EncodingMode.DYNAMIC_MODE);
		JsoniterAnnotationSupport.enable();
	}

	public int objectDeserializeTest()
	{
		// TODO Auto-generated method stub

		try
		{
			JsonIterator.parse(jsonData).read(userListType);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 1;

	}

	public int rawDeserializeTest()
	{
		JsonIterator.deserialize(jsonData);
		
		return 1;

	}

	public void warmup()
	{

		try
		{
			JsonIterator.parse(jsonData).read(userListType);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
*/
