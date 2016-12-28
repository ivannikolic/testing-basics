This is a demo project to show some unit testing basics.
System does the following:
* It gets user's email address from CLI and validates it
* It generates chatName out of it
* It registers user on the chat
* User gets the email with credentials

Let's assume implementation for ChatProvider already exists.

Chat names are generated from email using following rules:
* Only alphanumeric alphanumeric characters should be used, every other character should be removed
* Chat name should be in lower case
* Chat name must be at least 5 characters long - additional characters might be added
* Chat name must be at at most 11 characters long - some characters at the end might be removed
* Chat name must not contain word "admin". If it does it will be replaced by word "user"
