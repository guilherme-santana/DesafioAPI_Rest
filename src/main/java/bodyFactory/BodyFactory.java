package bodyFactory;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import util.ReadProperties;

public class BodyFactory {
	
	public static JSONObject bodyPosts(String tipoMassa) throws IOException, Exception {
		JSONObject posts = new JSONObject();
		Properties mt = new ReadProperties().read("massas");
		String[] dados = StringUtils.split((String) mt.get("post."+tipoMassa),",");
		try {

			if(!dados[0].contains("null")) {
				posts.put("title", dados[0]);
			}
			if(!dados[1].contains("null")) {
				posts.put("body", dados[1]);
			}
			if(!dados[2].contains("null")) {
				posts.put("userId", dados[2]);
			}

		} catch(JSONException e) {
			e.printStackTrace();
		}

		return posts;
	}
	

}
