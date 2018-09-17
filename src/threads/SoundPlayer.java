package threads;

import java.util.LinkedHashMap;

import java.util.Map;

public class SoundPlayer {

    // KEY -> String identifier (Bsp.: "Sound A", "Backgroundmusic")
    // VALUE -> SoundThread vom Sound
    private Map<String, SoundThread> soundThreads = null;

    private static SoundPlayer instance;

    /**
     * Returns the current SoundPlayer instance
     *
     * @return instance
     */
    public static SoundPlayer getInstance() {
        if (instance == null) {
            instance = new SoundPlayer();
        }
        return instance;
    }

    private SoundPlayer() {
        soundThreads = new LinkedHashMap<>();
    }

    /**
     * Plays the Sound at
     * <p>
     * filePath</p> as identifier
     * <p>
     * identifier</p>
     *
     * @param identifier
     * @param filePath
     */
    public void play(String identifier, String filePath, boolean loop) {
        soundThreads.putIfAbsent(identifier, new SoundThread(filePath, loop));
        SoundThread soundThread = soundThreads.getOrDefault(identifier, null);
        if (soundThread.isPlaying()) {
            //    System.out.println("Sound \"" + identifier + "\" is being replaced!");
            soundThread.close();
        } else {
            //   System.out.println("Sound \"" + identifier + "\" is being played!");
        }
        soundThread = new SoundThread(filePath, loop);
        soundThreads.put(identifier, soundThread);
        new Thread(soundThread).start();
    }

    /**
     * Stops all Sounds
     */
    public void closeAll() {
        for (String key : soundThreads.keySet()) {
            this.close(key);
        }
    }

    /**
     * Stops the sound which has the identifier named
     * <p>
     * identifier</p>
     *
     * @param identifier
     */
    public void close(String identifier) {
        SoundThread soundThread = soundThreads.getOrDefault(identifier, null);
        if (soundThread == null) {
            //    System.out.println("There is no Sound that can be closed with identifier \"" + identifier + "\"");
            return;
        }

        if (soundThread.isPlaying()) {
            soundThread.close();
            System.out.println("Sound \"" + identifier + "\" was stopped!");
        } else {
            System.out.println("Sound \"" + identifier + "\" is not being played right now!");
        }
    }

    public boolean isPlaying(String key) {
        if (soundThreads.containsKey(key)) {
            return soundThreads.get(key).isPlaying();
        }
        return false;
    }

    public boolean isFinished(String key) {
        if (soundThreads.containsKey(key)) {
            return soundThreads.get(key).isFinished();
        }
        return false;
    }

    public String getLastPlaying(String key) {
        return soundThreads.containsKey(key) ? soundThreads.get(key).getFile().getName() : null;
    }
}
