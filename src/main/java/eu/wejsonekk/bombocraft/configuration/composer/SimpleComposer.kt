package eu.wejsonekk.bombocraft.configuration.composer

import net.dzikoysk.cdn.serdes.Composer
import net.dzikoysk.cdn.serdes.SimpleDeserializer
import net.dzikoysk.cdn.serdes.SimpleSerializer

interface SimpleComposer<T> : Composer<T>, SimpleDeserializer<T>, SimpleSerializer<T>
