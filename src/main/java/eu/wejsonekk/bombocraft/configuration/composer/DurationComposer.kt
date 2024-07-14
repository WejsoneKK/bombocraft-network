package eu.wejsonekk.bombocraft.configuration.composer

import panda.std.Result
import java.time.Duration
import java.time.format.DateTimeParseException

class DurationComposer : SimpleComposer<Duration?> {

    override fun serialize(entity: Duration?): Result<String, java.lang.Exception> {
        return Result.ok(entity.toString().substring(2).lowercase())
    }

    override fun deserialize(source: String): Result<Duration?, Exception>? {
        return Result.supplyThrowing(DateTimeParseException::class.java) { Duration.parse("PT" + source.uppercase()) }
    }

}
