package ru.sergeykarleev.useuconverter.classes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;


/**����� ��������� ������ � ����� � ����������� ������ � ���������� ���� XML ������
 * @author SergeyKarleev
 *
 */
public class MyXMLAsyncLoader extends AsyncTaskLoader<String> {

	final static String LOG_TAG = "myLogs";
	
	String mRequest = null;
		
	public MyXMLAsyncLoader(Context context, Bundle args) {
		super(context);
		mRequest = args.getString("REQUEST");
		//Log.d(LOG_TAG, "����������� AsyncLoader �������� ������: "+mRequest);
	}

	@Override
	public String loadInBackground() {
		URL url;
		InputStream inputStream;
		
		try {
			url = new URL(mRequest);
			inputStream = url.openStream();			
			return new Scanner(inputStream).useDelimiter("\\A").next();
		}catch (java.util.NoSuchElementException e) {			
			return e.toString();
		}catch (IOException e1) {			
			return e1.toString();
		} 
		
	}
	


}
