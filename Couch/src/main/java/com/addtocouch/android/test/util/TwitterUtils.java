package com.addtocouch.android.test.util;

import android.content.Context;

import com.addtocouch.android.test.R;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by justinschultz on 11/17/13.
 */
public class TwitterUtils {
	public void postTweet(Context context, String tweet) {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey(context.getString(R.string.twitter_consumer_key));
		builder.setOAuthConsumerSecret(context.getString(R.string.twitter_access_token_secret));
		builder.setOAuthConsumerKey(context.getString(R.string.twitter_consumer_key));
		builder.setOAuthConsumerSecret(context.getString(R.string.twitter_access_token_secret));

		String accessToken = context.getString(R.string.twitter_access_token_key);

		Twitter twitter = new TwitterFactory(builder.build()).getInstance();
		try {
			twitter.updateStatus(tweet);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
