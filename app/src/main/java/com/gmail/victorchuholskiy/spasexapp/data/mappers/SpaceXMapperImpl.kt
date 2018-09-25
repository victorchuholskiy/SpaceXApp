package  com.gmail.victorchuholskiy.spasexapp.data.mappers

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.LaunchResponse
import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.RocketResponse

/**
 * Created by aleksey.stepanov
 * 4/23/18.
 */
object SpaceXMapperImpl : SpaceXMapper {

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
				remote.details,
				remote.engines!!.number)
	}

	override fun map(remote: LaunchResponse, rocketId: String): Launch {
		return Launch(
				remote.flightNumber,
				rocketId,
				if (remote.missionName == null) "" else remote.missionName!!,
				if (remote.launchYear.isNullOrEmpty()) 0 else Integer.valueOf(remote.launchYear!!),
				remote.launchDateUnix,
				remote.launchSuccess,
				remote.links!!.missionPatch
		)
	}
}