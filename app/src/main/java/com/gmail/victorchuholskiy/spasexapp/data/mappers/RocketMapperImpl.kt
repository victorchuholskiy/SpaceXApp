package  com.gmail.victorchuholskiy.spasexapp.data.mappers

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.RocketResponse

/**
 * Created by aleksey.stepanov
 * 4/23/18.
 */
object RocketMapperImpl : RocketMapper {

	override fun map(remote: RocketResponse): Rocket {
		return Rocket(
				remote.id,
				remote.active,
				remote.stages,
				remote.boosters,
				remote.costPerLaunch,
				remote.firstFlight,
				remote.country,
				remote.company,
				remote.rocketId,
				remote.rocketName,
				remote.engines!!.number)
	}
}