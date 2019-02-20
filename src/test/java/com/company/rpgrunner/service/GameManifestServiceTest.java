package com.company.rpgrunner.service;

import com.company.rpgrunner.repository.gamemanifest.GameManifestLoader;
import com.company.rpgrunner.repository.gamemanifest.model.GameManifest;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.runner.RunWith;

import java.util.Optional;

import static org.easymock.EasyMock.expect;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by Leonardo Tonin on 19/02/19.
 */
@RunWith(EasyMockRunner.class)
public class GameManifestServiceTest extends EasyMockSupport {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @TestSubject
    private GameManifestService gameManifestService = GameManifestService.getInstance();

    @Mock
    private GameManifestLoader gameManifestLoader;

    @Test
    public void loadAMissingManifestFileMustExitGame() {
        expect(gameManifestLoader.load("game-manifest")).andReturn(Optional.empty());
        replayAll();

        exit.expectSystemExit();
        gameManifestService.load();
        verifyAll();
    }

    @Test
    public void loadAExistentManifestFileMustReturnAGameManifest() {
        GameManifest gameManifest = getGameManifest();

        expect(gameManifestLoader.load("game-manifest")).andReturn(Optional.of(gameManifest));
        replayAll();

        GameManifest load = gameManifestService.load();

        assertThat(load, is(equalTo(gameManifest)));
        verifyAll();
    }

    private GameManifest getGameManifest() {
        GameManifest gameManifest = new GameManifest();
        gameManifest.setStartLocation("tavern");
        gameManifest.setPlayerInitialLife("10");
        gameManifest.setPlayerInitialDamage("3");
        return gameManifest;
    }
}
