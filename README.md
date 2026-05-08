# Project Title Goes Here

This GitHub repository includes the classes used for our final project, which is an Angry Birds Game. The classes include the actual Angry Birds Game, Birds, Bricks, Pigs, and the Slingshot.
When installing Java, you need to know what kind of computer you are using. For Window user, you just select the Windows icon. For Mac users, you need to know what kind of processor your computer has. In order to see this, go to the Apple Menu and press about this Mac. Look for a heading called either Processor or Chip, and it will say something that has either the word "Intel" or "Apple". Linux users can just select anything. First go to https://adoptium.net. Mac users will be sent to the Adoptium homepage where you will find a big red button. Double check that you have the offered installer, and open the installer when the downloading process is complete. Go through the installation process, and accept all the defaults. Windows users will go through the installation process accepting all the defaults. If the installer asks you to make changes to you device, click Yes. Ensure that the JAVA_HOME variable is selected by clicking the dropdown menu and selecting it. The folder area where JDK will be installed will be called "Eclipse Adoptium".
The second step is downloading VS Code. In order to do this, go to https://code.visualstudio.com/ and click the download button. Mac users should move the downloaded file from the Downloads folder into the Applications folder. For Windows users, double-click the VS Code app to open and run it. Accept the license agreement and click Next. You can keep clicking “Next” to accept all the installation settings, with one caveat: make sure you enable the following three options on the “Select Additional Tasks” screen:
☑ Add "Open with Code" action to Windows Explorer file context menu
☑ Add "Open with Code" action to Windows Explorer directory context menu
☑ Register Code as an editor for supported file types
When you finish configuring, click the Install button. When the installation is complete, make sure that "Launch Visual Studio Code" is checked and click Finish.
Once VS Code starts up and you get a Welcome screen, click the Extensions icon. It is located on the sidebar to the left with three connected squares and a titled square in the upper right. Type Java in the "Search Extensions" box. One of the results should be the Extension Pack for Java from Microsoft. If you can't find it, don't panic. Use https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack and follow the instructions. After getting the correct extension, press Install. To verify that it worked, open VS Code's "command palette" and type Java. There should be a bunch of commands that start with Java. After confirming, press the Escape button. If you don't see the commands, try quitting and resetting, and repeat the installation step. If that doesn't work, go back to the Extension step. If that still doesn't work, ask the instructor for assistance. Once that's figured out, open up the "command palette" again and search "user settings json". Click Preferences: Open User Settings (JSON) to open a new window. Delete everything in the file and replace it with the following:
{
  "files.autoSave": "onFocusChange",
  "java.server.launchMode": "Standard",
  "java.import.generatesMetadataFilesAtProjectRoot": true,
  "extensions.autoUpdate": false,
  "chat.disableAIFeatures": true,

}
Save the file and restart VS Code.

Now we have to download Git. For Mac users, press command-space. Type the word Terminal. Click the top result.