package pack;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/*
 * のんぽぐさんのコードを参考、ローカルでは動くがherokuではbuildpackが必要のためか動かない
 */
public class Audio {

	File gamePath = new File("/Users/yoshidayasuko/workspace2/Treasure10/src/sample.wav");
	File collectPath = new File("/pleiades/workspace/Treasure10/src/poka.wav");	
	File unCollectPath = new File("/pleiades/workspace/Treasure10/src/buin.wav");
	
	public void audioGame() throws InterruptedException {
		
	
		Clip clip = createClipGame(gamePath);
		clip.start();
		Thread.sleep(9000);
		clip.close();
		//ここで再生メソッドの呼び出し

	}
	public void audioCollect() throws InterruptedException {
		
		
		Clip clip = createClipCollect(collectPath);
		clip.start();
		Thread.sleep(500);
		clip.close();
		//ここで再生メソッドの呼び出し

	}
public void audioUnCollect() throws InterruptedException {
		
		
		Clip clip = createClipUnCollect(unCollectPath);
		clip.start();
		Thread.sleep(1000);
		clip.close();
		//ここで再生メソッドの呼び出し

	}
	
	public  Clip createClipGame(File path) {
		
		//指定されたURLのオーディオ入力ストリームを取得
		try(AudioInputStream ais =AudioSystem.getAudioInputStream(gamePath)){
			
			//ファイルの形式取得
			AudioFormat af = ais.getFormat();
			
			//単一のオーディオ形式を含む指定した情報からデータラインの情報オブジェクトを構築
			DataLine.Info dataLine = new DataLine.Info(Clip.class,af);
			
			//指定された　Line.Info　オブジェクトの記述に一致するラインを取得
			Clip c= (Clip)AudioSystem.getLine(dataLine);
			
			//再生準備完了
			c.open(ais);
			
			return c;
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(UnsupportedAudioFileException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(LineUnavailableException e) {
			e.printStackTrace();
		}
		return null;
	}
public  Clip createClipCollect(File path) {
		
		//指定されたURLのオーディオ入力ストリームを取得
		try(AudioInputStream ais =AudioSystem.getAudioInputStream(collectPath)){
			
			//ファイルの形式取得
			AudioFormat af = ais.getFormat();
			
			//単一のオーディオ形式を含む指定した情報からデータラインの情報オブジェクトを構築
			DataLine.Info dataLine = new DataLine.Info(Clip.class,af);
			
			//指定された　Line.Info　オブジェクトの記述に一致するラインを取得
			Clip c= (Clip)AudioSystem.getLine(dataLine);
			
			//再生準備完了
			c.open(ais);
			
			return c;
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(UnsupportedAudioFileException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(LineUnavailableException e) {
			e.printStackTrace();
		}
		return null;
	}
public  Clip createClipUnCollect(File path) {
	
	//指定されたURLのオーディオ入力ストリームを取得
	try(AudioInputStream ais =AudioSystem.getAudioInputStream(unCollectPath)){
		
		//ファイルの形式取得
		AudioFormat af = ais.getFormat();
		
		//単一のオーディオ形式を含む指定した情報からデータラインの情報オブジェクトを構築
		DataLine.Info dataLine = new DataLine.Info(Clip.class,af);
		
		//指定された　Line.Info　オブジェクトの記述に一致するラインを取得
		Clip c= (Clip)AudioSystem.getLine(dataLine);
		
		//再生準備完了
		c.open(ais);
		
		return c;
	}catch(MalformedURLException e) {
		e.printStackTrace();
	}catch(UnsupportedAudioFileException e){
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}catch(LineUnavailableException e) {
		e.printStackTrace();
	}
	return null;
}

}
