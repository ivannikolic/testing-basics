package rs.atessoft.api;

import rs.atessoft.chat.ChatProviderException;

import java.util.List;

/**
 * @author Ivan
 */
public interface ChatProvider {

    void login(String chatName, String password) throws ChatProviderException;

    void registerChatName(String chatName) throws ChatProviderException;

    void deleteChatMessage(String chatName) throws ChatProviderException;

    void sendChatMessage(String from, String to, String message) throws ChatProviderException;

    void sendGroupChatMessage(String from, String message) throws ChatProviderException;

    List<String> getAllChatNames(String from, String message) throws ChatProviderException;

}
