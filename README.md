# Angry Birds Game

## About This Repository

This GitHub repository includes the classes used for our final project, which is an Angry Birds Game. The classes include the actual Angry Birds Game, Birds, Bricks, Pigs, and the Slingshot.

## Required Software and Versions

The version of VS Code needed is VSCode1.108.2, and the version of GitHub Desktop needed is Version 3.5.8 (arm64).

## Presentation Slides and Presentation Video

Presentation Slides Link: https://docs.google.com/presentation/d/1h6Cm0njqBu-rkDL_1CGS2mtbPr24sdK524_eTnA63ng/edit?slide=id.gc6f73a04f_0_0#slide=id.gc6f73a04f_0_0

Video Presentation Link: https://youtu.be/viXJg4JNMHI

## Setup and Run Instructions

When installing Java, you need to know what kind of computer you are using. For Window users, you just select the Windows icon. For Mac users, you need to know what kind of processor your computer has. In order to see this, go to the Apple Menu and press about this Mac. Look for a heading called either Processor or Chip, and it will say something that has either the word "Intel" or "Apple". First go to https://adoptium.net. Mac users will be sent to the Adoptium homepage where you will find a big red button. Double check that you have the offered installer, and open the installer when the downloading process is complete. Go through the installation process, and accept all the defaults. Windows users will go through the installation process and accept all the defaults. If the installer asks you to make changes to you device, click Yes. Ensure that the JAVA_HOME variable is selected by clicking the dropdown menu. The folder area where JDK will be installed will be called "Eclipse Adoptium".

The second step is downloading VS Code. In order to do this, go to https://code.visualstudio.com/ and click the download button. Mac users are advised to move the downloaded file from the Downloads folder into Applications. For Windows users, double-click the VS Code app to start it. Accept the license agreement and click Next. You can keep clicking “Next” to accept all the installation settings, with one caveat: make sure you enable the following three options on the “Select Additional Tasks” screen:
☑ Add "Open with Code" action to Windows Explorer file context menu
☑ Add "Open with Code" action to Windows Explorer directory context menu
☑ Register Code as an editor for supported file types

When you finish configuring, click the Install button. When the installation is complete, make sure that "Launch Visual Studio Code" is checked and click Finish.
Once VS Code starts up and you get a Welcome screen, click the Extensions icon. It is located on the sidebar to the left with three connected squares and a titled square in the upper right. Type Java in the "Search Extensions" box. One of the results should be the Extension Pack for Java from Microsoft. If you can't find it, don't panic. Use https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack and follow the instructions. After getting the correct extension, press Install. To verify that it worked, open VS Code's "command palette" and type Java. There should be a bunch of commands that start with the word Java. After confirming, press the Escape button. If you don't see the commands, try quitting and resetting, and repeat the installation step. If that doesn't work, go back to the Extension step. If that still doesn't work, ask your instructor for assistance. Once that's figured out, open up the "command palette" again and search "user settings json". Click Preferences: Open User Settings (JSON) to open a new window. Delete everything in the file and replace it with the following:
{
  "files.autoSave": "onFocusChange",
  "java.server.launchMode": "Standard",
  "java.import.generatesMetadataFilesAtProjectRoot": true,
  "extensions.autoUpdate": false,
  "chat.disableAIFeatures": true,

}
Save the file and restart VS Code.

Now we have to download Git. For Mac users, press command-space. Type the word Terminal. Click the top result. In the window that appears, type git --version and press enter. If you see a message like this:
Last login: Wed Aug 13 11:23:58 on ttys000 dan@macos ~ % git --version
 git version 2.48.1 (Apple Git-128)
 dan@macos ~
then you have installed git in the past and you can disregard the new few steps.
If you see an error message that says “No developer tools found” or “invalid active developer path,” then type sudo xcode-select --reset in the Terminal and press enter. It will ask you for your computer password, but you will not be able to see what you are typing. Don't worry, it is working. Type your password and press return. Then, type xcode-select --install into the Terminal and press enter.

Be patient; the installation process will take a few minutes. Once it’s done, go back to that Terminal window and type git --version again. You should get a version number. For Windows users, go to http://git-scm.com/downloads and click the Download button for the most recent release. Open and run the downloaded installer. Select yes if a screen pops up. You can click through most of the defaults by clicking “Next". EXCEPT FOR TWO: when you get to the “Choosing the default editor used by Git” step, choose Visual Studio Code. When asked about the “initial branch name in new repositories”, please choose Override the default: and set the initial name to "main". When asked about the “initial branch name in new repositories”, please choose Override the default: and set the initial name to "main".

Exit out of VS Code and launch it again. Click the icon on the left that has three circles connected by two squiggles. If you see a message other than one that starts with "In order to use git features", ask your instructor for help. If not, continue to the next step.
To install GitHub Desktop, click the following link: https://desktop.github.com/download/ and choose what computer you are using. Install GitHub Desktop when it's done downloading. Once it's installed, click Sign in. Authorize GitHub Desktop and press Accept. Enter your real name, but don't change the email. Congratulations, you are all done with setting everything up. 

## Known Limitations and Bugs

The software does not really have any bugs that we know of. 

## References and Resources

While developing the software, we used past homeworks and Take-Home Activities.