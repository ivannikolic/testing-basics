package rs.atessoft.chat;

import com.beust.jcommander.internal.Lists;
import rs.atessoft.api.ChatProvider;

import java.util.List;

/**
 * @author Ivan
 */
public class ChatProviderImpl implements ChatProvider {

    @Override
    public void login(String chatName, String password) throws ChatProviderException {
        System.out.println("logging in with username/pass " + chatName + "/" + password);
    }

    @Override
    public void registerChatName(String chatName) throws ChatProviderException {
        System.out.println("registring chatName " + chatName);
    }

    @Override
    public void deleteChatMessage(String chatName) throws ChatProviderException {
        System.out.println("delete chat message " + chatName);
    }

    @Override
    public void sendChatMessage(String from, String to, String message) throws ChatProviderException {
        System.out.println("sending chat message from " + from + " to " + to + ", message text: " + message);
    }

    @Override
    public void sendGroupChatMessage(String from, String message) throws ChatProviderException {
        System.out.println("sending chat message from " + from + ", message text: " + message);
    }

    @Override
    public List<String> getAllChatNames(String from, String message) throws ChatProviderException {
        return Lists.newArrayList();
    }
}
