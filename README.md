# NBT
A java package for interacting with Minecraft Java NBT data

This package is designed to interface with Minecraft Java NBT Data Version 19133 (Minecraft 1.2 onward) using a variety of Java classes
and interfaces.

## Classes
The NBT package contains the following public classes:
* The ``TagByte`` class, for interfacing with ``TAG_Byte`` NBT tags
* `` TagShort`` class, for ``TAG_Short`` NBT tags
* ``TagInt`` class, for ``TAG_Int`` NBT tags
* ``TagLong`` class, for ``TAG_Long`` NBT tags
* ``TagFloat`` class, for ``TAG_Float`` NBT tags
* ``TagDouble`` class, for ``TAG_Double`` NBT tags
* ``TagByteArray`` class, for ``TAG_Byte_Array`` NBT tags
* ``TagString`` class, for ``TAG_String`` NBT tags
* ``TagList`` class, for ``TAG_List`` NBT tags
* ``TagCompound`` class, for ``TAG_Compound`` NBT tags
* ``TagIntArray`` class, for ``TAG_Int_Array`` NBT tags
* ``TagLongArray`` class, for ``TAG_Long_Array`` NBT tags

The package also contains higher level classes for interacting with the following Minecraft Java files
* ``level.dat`` (class ``LevelNBT``)
* ``<player>.dat`` (class ``PlayerNBT``)
* ``map_<#>.dat`` (class ``MapNBT``)
* ``servers.dat`` (class ``ServerNBT``)
* ``scoreboard.dat`` (class ``ScoreboardNBT``)
* ``Saved structures`` (class ``StructureNBT``)
