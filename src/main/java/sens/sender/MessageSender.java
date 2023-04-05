package sens.sender;

import sens.response.MessageResponse;
import sens.template.MessageTemplate;

public interface MessageSender {

    MessageResponse send(MessageTemplate messageTemplate);

    MessageResponse checkMessageSend();
}
