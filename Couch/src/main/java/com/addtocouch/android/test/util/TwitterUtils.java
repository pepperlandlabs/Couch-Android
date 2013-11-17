package com.addtocouch.android.test.util;

import android.content.Context;
import android.widget.Toast;

import com.addtocouch.android.test.R;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by justinschultz on 11/17/13.
 */
public class TwitterUtils {
	public static void postTweet(Context context, String tweet) {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey(context.getString(R.string.twitter_consumer_key))
				.setOAuthConsumerSecret(context.getString(R.string.twitter_consumer_secret))
				.setOAuthAccessToken(context.getString(R.string.twitter_access_token_key))
				.setOAuthAccessTokenSecret(context.getString(R.string.twitter_access_token_secret));
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		try {
			Status status = twitter.updateStatus(tweet);
			Toast.makeText(context, status.getText(), Toast.LENGTH_LONG).show();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
