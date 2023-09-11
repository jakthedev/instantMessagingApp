// Need to set the
// User thisUser = userService.getUser(userid);
// thisUser.setChannelUserIsIn();

// I need to register the channel to the User,
// doing this in the javascript file, and not here.

document.getElementById("@{/welcome/messagingChat/} + ${channel.channelId}").addEventListener("click", function() {
    // do something when the link is clicked
});