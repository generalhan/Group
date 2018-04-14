package com.common.robbot;

import java.util.Map;

import com.iflytek.cloud.speech.Setting;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;  

public class SpeakService {  
      
    public static SynthesizerListener synthesizeListener;  
  
    public void start(Map<String, String> mParamMap,String mText) {  
        // TODO Auto-generated method stub  
        Setting.setShowLog(true);  
        SpeechUtility.createUtility(SpeechConstant.APPID +"=5a06abac");     
   
        SpeechSynthesizer mTts= SpeechSynthesizer.createSynthesizer( );    
          
        mTts.setParameter(SpeechConstant.VOICE_NAME, mParamMap.get("VOICE_NAME"));  
        mTts.setParameter(SpeechConstant.BACKGROUND_SOUND,mParamMap.get("BACKGROUND_SOUND"));  
        mTts.setParameter(SpeechConstant.SPEED, mParamMap.get("SPEED"));   
        mTts.setParameter(SpeechConstant.PITCH, mParamMap.get("PITCH"));  
        mTts.setParameter(SpeechConstant.VOLUME, mParamMap.get("VOLUME"));  
        
        synthesizeListener = new SynthesizerListener() {  
  
           
            public void onBufferProgress(int arg0, int arg1, int arg2,  
                    String arg3) {  
                // TODO Auto-generated method stub  
                  
            }  
  
           
            public void onCompleted(SpeechError error) {  
                // TODO Auto-generated method stub  
                   System.out.println( "onCompleted enter: "+error );  
                   if( null != error ){  
                     System.out.println( "error: "+error.getErrorCode() );  
                   }  
                   System.out.println( "onCompleted leave" );  
            }  
  
             
            public void onSpeakBegin() {  
                // TODO Auto-generated method stub  
                  
            }  
  
         
            public void onSpeakPaused() {  
                // TODO Auto-generated method stub  
                  
            }  
  
           
            public void onSpeakProgress(int arg0, int arg1, int arg2) {  
                // TODO Auto-generated method stub  
                  
            }  
  
            
            public void onSpeakResumed() {  
                // TODO Auto-generated method stub  
                  
            }


			public void onEvent(int arg0, int arg1, int arg2, int arg3, Object arg4, Object arg5) {
				// TODO Auto-generated method stub
				
			}    
           
        };   
          
        mTts.startSpeaking( mText, synthesizeListener );  
    }  
}

