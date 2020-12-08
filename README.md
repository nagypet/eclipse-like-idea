#-------------------------------------------------------------------------------
# Copyright 2020 Peter Nagy
# 
# Licensed under the Apache License, Version 2.0 (the "License"); you may not
# use this file except in compliance with the License.  You may obtain a copy
# of the License at
# 
#   http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
# WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
# License for the specific language governing permissions and limitations under
# the License.
#-------------------------------------------------------------------------------
# eclipse-like-idea
Customizing Eclipse to be as close as possible to IntelliJ IDEA

As I started a new project in a regulated environment I was forced to move to Eclipse, since this was the accepted IDE. Up to now I was using solely IntelliJ IDEA, which is probably the best IDE nowadays. With a little customization we can setup Eclipse to look like IDEA and also behave more or less like IDEA. I still have a problem with key mappings but the look&feel is almost perfect.

Resources: 
[Complete guide to migrate to Eclipse/Spring Tool Suite (STS) IDE from IntelliJ Idea IDE](https://techfact555.blogspot.com/2020/04/change-eclipsespring-tool-suite-sts-ide.html)

Before:
![](https://github.com/nagypet/eclipse-like-idea/blob/main/docs/before.jpg)
After:
![](https://github.com/nagypet/eclipse-like-idea/blob/main/docs/after.jpg)

## Installation

1. Download the [JetBrains Mono](https://www.jetbrains.com/lp/mono/) font and install all of them.
1. Copy and overwrite all the *.prefs files from .metadata\.plugins\org.eclipse.core.runtime\.settings\ into your workspace.
