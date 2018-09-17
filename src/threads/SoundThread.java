package threads;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SoundThread implements Runnable {

    private File file;
    private AdvancedPlayer player = null;
    private boolean playing = false;
    private boolean finished = false;
    private boolean loop = false;

    public SoundThread(String filePath, boolean loop) {
        this.file = new File(filePath);
        this.loop = loop;
    }

    @Override
    public void run() {
        try {
            do {
                player = new AdvancedPlayer(new FileInputStream(file));
                playing = true;
                finished = false;
                player.play();
                player.close();
            } while (loop);
            this.close();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        playing = false;
        finished = true;
        loop = false;
        player.close();
    }

    public void stop() {
        playing = false;
        player.stop();
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isPlaying() {
        return playing;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isLoop() {
        return loop;
    }

    public File getFile() {
        return file;
    }
}
