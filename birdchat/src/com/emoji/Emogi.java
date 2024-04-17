package com.emoji;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Emogi {

    private static Emogi instance;

    public static Emogi getInstance() {
        if (instance == null) {
            instance = new Emogi();
        }
        return instance;
    }

    private Emogi() {
    }

    public List<ModelEmoji> getStyle1() {
        List<ModelEmoji> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(new ModelEmoji(i, new ImageIcon(getClass().getResource("/com/raven/emoji/icon/" + i + ".png"))));
        }
        return list;
    }

    public List<ModelEmoji> getStyle2() {
        List<ModelEmoji> list = new ArrayList<>();
        for (int i = 21; i <= 40; i++) {
            list.add(new ModelEmoji(i, new ImageIcon(getClass().getResource("/com/raven/emoji/icon/" + i + ".png"))));
        }
        return list;
    }

    public ModelEmoji getImoji(int id) {
        return new ModelEmoji(id, new ImageIcon(getClass().getResource("/com/raven/emoji/icon/" + id + ".png")));
    }
}
