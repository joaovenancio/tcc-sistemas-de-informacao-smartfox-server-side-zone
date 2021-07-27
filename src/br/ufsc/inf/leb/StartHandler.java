package br.ufsc.inf.leb;

import com.smartfoxserver.v2.SmartFoxServer;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.variables.RoomVariable;
import com.smartfoxserver.v2.entities.variables.SFSRoomVariable;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class StartHandler extends BaseClientRequestHandler {

    @Override
    public void handleClientRequest(User user, ISFSObject isfsObject) {

        trace( "Initializing game on Room " + user.getLastJoinedRoom().getName() + "#" +
                user.getLastJoinedRoom().getId() + ".");

        if ( (user.getLastJoinedRoom().getPlayersList().size() <= user.getLastJoinedRoom().getMaxUsers()) &&
                ( user.getLastJoinedRoom().getPlayersList().size() >= ServerSetupVariables.MIN_PLAYERS_TO_START.getIntValue() ) ){

            if (user.getLastJoinedRoom().containsVariable("turn")) {

                RoomVariable turn = new SFSRoomVariable("turn", "RP1");
                turn.setGlobal(true);
                turn.setPrivate(true);

                getApi().setRoomVariables(null, user.getLastJoinedRoom(), Arrays.asList(turn));

            }

        }

        trace("Room " + user.getLastJoinedRoom().getName() + "#" + user.getLastJoinedRoom().getId() + " turn changed: " +
                user.getLastJoinedRoom().getVariable("turn").getStringValue());

    }



}
