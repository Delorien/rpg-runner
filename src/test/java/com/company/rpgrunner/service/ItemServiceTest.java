package com.company.rpgrunner.service;

import com.company.rpgrunner.commons.GameMessage;
import com.company.rpgrunner.commons.exception.GameInitializationException;
import com.company.rpgrunner.repository.item.ItemLoader;
import com.company.rpgrunner.repository.item.model.Item;
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
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by Leonardo Tonin on 19/02/19.
 */
@RunWith(EasyMockRunner.class)
public class ItemServiceTest extends EasyMockSupport {

    @TestSubject
    private ItemService itemService = ItemService.getInstance();

    @Mock
    private ItemLoader itemLoader;

    @BeforeClass
    public static void initialize() throws GameInitializationException {
        GameMessage.initialize();
    }

    @Test
    public void interactWithAInvalidItemMustReturnAInvalidChoiceResponse() {
        expect(itemLoader.load("beer")).andReturn(Optional.empty());
        replayAll();

        Response response = itemService.interactWith("beer");
        assertThat(response, is(instanceOf(SimpleMessageResponse.class)));
        assertThat(response.getMessage(), is(equalTo(getMessage(INVALID_CHOICE))));
        verifyAll();
    }

    @Test
    public void interactWithAValidItemMustReturnAValidResponse() {

        expect(itemLoader.load("blade")).andReturn(Optional.of(getABlade()));
        replayAll();

        Response response = itemService.interactWith("blade");
        assertThat(response, is(instanceOf(Response.class)));
        verifyAll();
    }

    private Item getABlade() {
        Item blade = new Item();
        blade.setName("blade");
        blade.setDescription("A big blade");
        return blade;
    }
}
