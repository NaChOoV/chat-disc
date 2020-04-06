/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc;

import android.app.Application;

import androidx.room.Room;

import java.util.List;
import org.junit.jupiter.api.Assertions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;

import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.ConversationService;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.MessageReceivedApiService;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.model.Conversation;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.UserRoomDatabase;
import cl.ucn.disc.dsm.fuenz.chatdisc.service.ConversationServiceTest;

public class RoomDatabaseTest {

    /**
     * The Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(RoomDatabaseTest.class);

    @Test
    public void testDatabase() {




    }
}
