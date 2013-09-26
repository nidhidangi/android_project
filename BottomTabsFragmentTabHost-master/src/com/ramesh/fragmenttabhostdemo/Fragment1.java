package com.ramesh.fragmenttabhostdemo;

import org.json.JSONObject;

import com.inc247.ChatSDK;
import com.inc247.ChatSDKEventsListener;
import com.inc247.errors.ChatSDKError;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

public class Fragment1 extends Fragment implements ChatSDKEventsListener {

	private TextView text;
	private Button btnChat;
	ChatSDK sdkObject;
    JSONObject jsonObject;
    private static final String TAG=Fragment1.class.getSimpleName();
    
	public Fragment1() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = LayoutInflater.from(getActivity()).inflate(R.layout.layout,
				null);
		text = (TextView) v.findViewById(R.id.text);
		if (getArguments() != null) {
			//
			try {
				String value = getArguments().getString("key");
				text.setText("Current Tab is: " + value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sdkObject=ChatSDK.initializeChat(getActivity());
			sdkObject.setChatEventsListener(this);
			sdkObject.checkAgentAvailability();
			
			jsonObject=new JSONObject();
			
			 try 
	            {
	                jsonObject.put("username","value");
	                jsonObject.put("email","value2");
	                jsonObject.put("accountnumber","value3");

	            }
	            catch(Exception e)
	            {
	                Log.e(TAG,"Exception "+e);
	            }

			
			btnChat=(Button)v.findViewById(R.id.buttonChat);
			btnChat.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) 
				{
			
					sdkObject.startChat(jsonObject, getActivity());
					//Log.e("Welcome", "its work");
					
				}
			});
			
			
		}
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	//

	@Override
	public void onAgentMessage(JSONObject arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChatAgentAvailability(JSONObject arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChatEnded(JSONObject arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChatError(ChatSDKError arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChatMaximized(JSONObject arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChatMinimized(JSONObject arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChatStarted(JSONObject arg0) {
		// TODO Auto-generated method stub
		
	}

}
