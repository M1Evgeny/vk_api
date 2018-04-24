package by.htp.vk.api;

import static by.htp.vk.utils.PropertiesManager.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class VkApi {
	private String valueUserId = getProperty("vk.userId");
	private String hostName = getProperty("vk.hostName");
	private String valueToken = getProperty("vk.token");

	private String methodWallPostCount = "/method/wall.get";
	private String methodMessageCount = "/method/messages.get";
	private String methodWallPost = "/method/wall.post";
	private String methodEditPost = "/method/wall.edit";
	private String methodAddCommentPost = "/method/wall.createComment";
	private String methodDeletePost = "/method/wall.delete";
	private String methodSendMessege = "/method/messages.send";
	private String methodDeleteMessege = "/method/messages.delete";

	private String paramOwnerID = "owner_id";
	private String paramMessage = "message";
	private String paramPostId = "post_id";
	private String paramToken = "access_token";
	private String paramFilter = "filter";
	private String paramPeerId = "peer_id";
	private String paramMessageIds = "message_ids";

	private String post_count;
	private String post_id;
	private String message_count;
	private String messege_id;
	private String paramPost_id = "post_id";
	private String scheme = "https";
	private String response = "response";
	private String paramVersion = "v";
	private String valueVersion = "5.74";
	private String valueFilter = "owner";
	private String count = "count";

	private URIBuilder getWallPostCountUrl;
	private URIBuilder getMessageCountUrl;
	private URIBuilder createPostUrl;
	private URIBuilder editPostUrl;
	private URIBuilder deletePostUrl;
	private URIBuilder createCommentUrl;
	private URIBuilder sendMessegeUrl;
	private URIBuilder deleteMessegeUrl;

	public String getPost_count() {
		return post_count;
	}

	public String getPost_id() {
		return post_id;
	}

	public String getMessage_count() {
		return message_count;
	}

	public String getMessege_id() {
		return messege_id;
	}

	public void getWallPostCount() {
		getWallPostCountUrl = new URIBuilder();
		getWallPostCountUrl.setScheme(scheme);
		getWallPostCountUrl.setHost(hostName);
		getWallPostCountUrl.setPath(methodWallPostCount);
		getWallPostCountUrl.addParameter(paramOwnerID, valueUserId);
		getWallPostCountUrl.addParameter(paramFilter, valueFilter);
		getWallPostCountUrl.addParameter(paramToken, valueToken);
		getWallPostCountUrl.addParameter(paramVersion, valueVersion);
		try {
			post_count = getParam(get(getWallPostCountUrl.build().toURL()), count);
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void getMessageCount() {
		getMessageCountUrl = new URIBuilder();
		getMessageCountUrl.setScheme(scheme);
		getMessageCountUrl.setHost(hostName);
		getMessageCountUrl.setPath(methodMessageCount);
		getMessageCountUrl.addParameter(paramToken, valueToken);
		getMessageCountUrl.addParameter(paramVersion, valueVersion);
		try {
			message_count = getParam(get(getMessageCountUrl.build().toURL()), count);
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void createPost(String message) {
		createPostUrl = new URIBuilder();
		createPostUrl.setScheme(scheme);
		createPostUrl.setHost(hostName);
		createPostUrl.setPath(methodWallPost);
		createPostUrl.addParameter(paramOwnerID, valueUserId);
		createPostUrl.addParameter(paramMessage, message);
		//createPostUrl.addParameter("attachments", "photo260893278_437261158");
		createPostUrl.addParameter(paramToken, valueToken);
		createPostUrl.addParameter(paramVersion, valueVersion);
		try {
			post_id = getParam(post(createPostUrl.build().toURL()), paramPost_id);
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void editPost(String postId, String message) {
		editPostUrl = new URIBuilder();
		editPostUrl.setScheme(scheme);
		editPostUrl.setHost(hostName);
		editPostUrl.setPath(methodEditPost);
		editPostUrl.addParameter(paramOwnerID, valueUserId);
		editPostUrl.addParameter(paramPost_id, postId);
		editPostUrl.addParameter(paramMessage, message);
		editPostUrl.addParameter(paramToken, valueToken);
		editPostUrl.addParameter(paramVersion, valueVersion);
		try {
			post(editPostUrl.build().toURL());
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void createComment(String postId, String message) {
		createCommentUrl = new URIBuilder();
		createCommentUrl.setScheme(scheme);
		createCommentUrl.setHost(hostName);
		createCommentUrl.setPath(methodAddCommentPost);
		createCommentUrl.addParameter(paramOwnerID, valueUserId);
		createCommentUrl.addParameter(paramPost_id, postId);
		createCommentUrl.addParameter(paramMessage, message);
		createCommentUrl.addParameter(paramToken, valueToken);
		createCommentUrl.addParameter(paramVersion, valueVersion);
		try {
			post(createCommentUrl.build().toURL());
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void deletePost(String postId) {
		deletePostUrl = new URIBuilder();
		deletePostUrl.setScheme(scheme);
		deletePostUrl.setHost(hostName);
		deletePostUrl.setPath(methodDeletePost);
		deletePostUrl.addParameter(paramOwnerID, valueUserId);
		deletePostUrl.addParameter(paramPostId, postId);
		deletePostUrl.addParameter(paramToken, valueToken);
		deletePostUrl.addParameter(paramVersion, valueVersion);
		try {
			post(deletePostUrl.build().toURL());
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void sendMessege(String messege) {
		sendMessegeUrl = new URIBuilder();
		sendMessegeUrl.setScheme(scheme);
		sendMessegeUrl.setHost(hostName);
		sendMessegeUrl.setPath(methodSendMessege);
		sendMessegeUrl.addParameter(paramOwnerID, valueUserId);
		sendMessegeUrl.addParameter(paramPeerId, valueUserId);
		sendMessegeUrl.addParameter(paramMessage, messege);
		sendMessegeUrl.addParameter(paramToken, valueToken);
		sendMessegeUrl.addParameter(paramVersion, valueVersion);
		try {
			messege_id = post(sendMessegeUrl.build().toURL()).get(response).toString();
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void deleteMessege(String messegeId) {
		deleteMessegeUrl = new URIBuilder();
		deleteMessegeUrl.setScheme(scheme);
		deleteMessegeUrl.setHost(hostName);
		deleteMessegeUrl.setPath(methodDeleteMessege);
		deleteMessegeUrl.addParameter(paramMessageIds, messegeId);
		deleteMessegeUrl.addParameter(paramToken, valueToken);
		deleteMessegeUrl.addParameter(paramVersion, valueVersion);
		try {
			post(deleteMessegeUrl.build().toURL());
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private JSONObject get(URL url) {
		CloseableHttpClient httpClient = HttpClientBuilder.create()
				.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build();
		HttpGet httpGet = new HttpGet(url.toString());
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getResponseInfo(response);
	}

	private JSONObject post(URL url) {
		CloseableHttpClient httpClient = HttpClientBuilder.create()
				.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build();
		HttpPost httpPost = new HttpPost(url.toString());
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getResponseInfo(response);
	}

	private JSONObject getResponseInfo(HttpResponse response) {
		try {
			InputStreamReader reader = new InputStreamReader(response.getEntity().getContent());
			BufferedReader bReader = new BufferedReader(reader);
			String inputLine;
			StringBuilder stBuilder = new StringBuilder();
			while ((inputLine = bReader.readLine()) != null) {
				stBuilder.append(inputLine);
			}
			reader.close();
			return (JSONObject) new JSONParser().parse(stBuilder.toString());
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getParam(JSONObject jo, String parameter) {
		return ((JSONObject) jo.get(response)).get(parameter).toString();
	}

}
