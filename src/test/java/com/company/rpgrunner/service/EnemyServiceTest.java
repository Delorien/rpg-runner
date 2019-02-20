package com.company.rpgrunner.service;

import com.company.rpgrunner.commons.GameMessage;
import com.company.rpgrunner.commons.exception.GameInitializationException;
import com.company.rpgrunner.repository.enemy.EnemyLoader;
import com.company.rpgrunner.repository.enemy.model.Enemy;
import com.company.rpgrunner.ui.response.EnemyViewResponse;
import com.company.rpgrunner.ui.response.Response;
import com.company.rpgrunner.ui.response.SimpleMessageResponse;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

import static com.company.rpgrunner.commons.GameMessage.INVALID_CHOICE;
import static com.company.rpgrunner.commons.GameMessage.getMessage;
import static org.easymock.EasyMock.expect;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Leonardo Tonin on 19/02/19.
 */
@RunWith(EasyMockRunner.class)
public class EnemyServiceTest extends EasyMockSupport {

    @TestSubject
    private EnemyService enemyService = EnemyService.getInstance();

    @Mock
    private EnemyLoader enemyLoader;

    @BeforeClass
    public static void initialize() throws GameInitializationException {
        GameMessage.initialize();
    }

    @Test
    public void loadFailMustReturnAOptionalEmpty() {

        expect(enemyLoader.load("goblin")).andReturn(Optional.empty());
        replayAll();

        Optional<Enemy> goblin = enemyService.load("goblin");
        assertThat(goblin, is(equalTo(Optional.empty())));
        verifyAll();
    }

    @Test
    public void loadSuccessMustReturnAOptionalWithAEnemy() {

        Enemy enemy = getAGoblin();
        expect(enemyLoader.load("goblin")).andReturn(Optional.of(enemy));
        replayAll();

        Optional<Enemy> goblin = enemyService.load("goblin");
        assertThat(goblin, is(equalTo(Optional.of(enemy))));
        verifyAll();
    }

    @Test
    public void checkAInvalidEnemyMustReturnAInvalidChoiceResponse() {
        expect(enemyLoader.load("merlin")).andReturn(Optional.empty());
        replayAll();

        Response response = enemyService.check("merlin");
        assertThat(response, is(instanceOf(SimpleMessageResponse.class)));
        assertThat(response.getMessage(), is(equalTo(getMessage(INVALID_CHOICE))));
        verifyAll();
    }

    @Test
    public void checkAValidEnemyMustReturnAEnemyViewResponse() {
        Enemy enemy = getAGoblin();
        expect(enemyLoader.load("goblin")).andReturn(Optional.of(enemy));
        replayAll();

        Response response = enemyService.check("goblin");
        assertThat(response, is(instanceOf(EnemyViewResponse.class)));
        assertThat(response.getMessage(), is(equalTo(new EnemyViewResponse(enemy).getMessage())));
        verifyAll();
    }

    private Enemy getAGoblin() {

        Enemy enemy = new Enemy();
        enemy.setName("Goblin");
        enemy.setDescription("A huge Goblin");
        enemy.setLife("5");
        enemy.setDamage("2");
        return enemy;
    }
}
