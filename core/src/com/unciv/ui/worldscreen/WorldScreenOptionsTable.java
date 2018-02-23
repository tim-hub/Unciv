package com.unciv.ui.worldscreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.unciv.logic.civilization.CivilizationInfo;
import com.unciv.ui.CivilopediaScreen;
import com.unciv.ui.ScienceVictoryScreen;
import com.unciv.ui.pickerscreens.PolicyPickerScreen;
import com.unciv.ui.utils.CameraStageBaseScreen;
import com.unciv.ui.utils.ImageGetter;

public class WorldScreenOptionsTable extends Table {

    private final CivilizationInfo civInfo;

    WorldScreenOptionsTable(final WorldScreen worldScreen, CivilizationInfo civInfo) {
        this.civInfo = civInfo;
        Drawable tileTableBackground = ImageGetter.getDrawable("skin/tileTableBackground.png")
                .tint(new Color(0x004085bf));
        setBackground(tileTableBackground);

        setVisible(false);

        TextButton OpenCivilopediaButton = new TextButton("Civilopedia", CameraStageBaseScreen.skin);
        OpenCivilopediaButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                worldScreen.game.setScreen(new CivilopediaScreen());
                setVisible(false);
            }
        });
        add(OpenCivilopediaButton).pad(10);
        row();

        TextButton StartNewGameButton = new TextButton("Start new game", CameraStageBaseScreen.skin);
        StartNewGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                worldScreen.game.startNewGame();
            }
        });
        add(StartNewGameButton).pad(10);
        row();

        TextButton OpenScienceVictoryScreen = new TextButton("Science victory status", CameraStageBaseScreen.skin);
        OpenScienceVictoryScreen.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                worldScreen.game.setScreen(new ScienceVictoryScreen(WorldScreenOptionsTable.this.civInfo));
            }
        });
        add(OpenScienceVictoryScreen).pad(10);
        row();

        TextButton OpenPolicyPickerScreen = new TextButton("Social Policies", CameraStageBaseScreen.skin);
        OpenPolicyPickerScreen.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                worldScreen.game.setScreen(new PolicyPickerScreen(WorldScreenOptionsTable.this.civInfo));
            }
        });
        add(OpenPolicyPickerScreen).pad(10);
        row();

        TextButton closeButton = new TextButton("Close", CameraStageBaseScreen.skin);
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setVisible(false);
            }
        });
        add(closeButton).pad(10);
        pack(); // Needed to show the background.
        setPosition(worldScreen.stage.getWidth() / 2 - getWidth() / 2,
                worldScreen.stage.getHeight() / 2 - getHeight() / 2);
    }

}
