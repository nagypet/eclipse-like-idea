# eclipse-like-idea
Customizing Eclipse to be as close as possible to IntelliJ IDEA

As I started a new project in a regulated environment I was forced to move to Eclipse, since this was the accepted IDE. Up to now I was using solely IntelliJ IDEA, which is probably the best IDE nowadays. With a little customization we can setup Eclipse to look like IDEA and also behave more or less like IDEA. 

Resources: 
[Complete guide to migrate to Eclipse/Spring Tool Suite (STS) IDE from IntelliJ Idea IDE](https://techfact555.blogspot.com/2020/04/change-eclipsespring-tool-suite-sts-ide.html)

Before:
![](https://github.com/nagypet/eclipse-like-idea/blob/main/docs/before.jpg)
After:
![](https://github.com/nagypet/eclipse-like-idea/blob/main/docs/after.jpg)

## Installation

1. Download the [JetBrains Mono](https://www.jetbrains.com/lp/mono/) font and install all of them.

1. The settings are located in an Eclipse workspace in the folder `.metadata\.plugins\org.eclipse.core.runtime\.settings\`. You can manually add those settings one by one. It is not recommended to replace the original files in the workspace, because other important setting, like cleanup and formatting may be overwritten. Instead open the files with a text editor and copy the items into the corresponding files in your workspace.

1. In the folder `compiled` there is a small tool (`merge-prefs`), which does the exact same with the exception, it can replace existing items as well. Alternatively you can download the sources and compile the project yourself with `gradlew dist`.

Please note that key settings are located in `org.eclipse.ui.workbench.prefs` at the key `org.eclipse.ui.commands`. I prefer __NetBeans__ shortcuts, if you want your own, please remove this key and make your own mapping. 

After importing the setting, please restart Eclipse. There is one small problem left, I do not yet understand: I removed some key bindings in order to avoid conflicts, but after running the `merge-prefs` tool those are still there. Therefore one must manually search for conflicting keys within Eclipse and remove them manually. If I will have some time I will continue investigating this issue. Any hints are wellcome!

### Actual key mapping
![](https://github.com/nagypet/eclipse-like-idea/blob/main/docs/keymaps.jpg)
