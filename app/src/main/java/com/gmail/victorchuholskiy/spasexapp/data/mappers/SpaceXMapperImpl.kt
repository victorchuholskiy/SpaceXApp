package  com.gmail.victorchuholskiy.spasexapp.data.mappers

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.LaunchResponse
import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.RocketResponse

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
				remote.description,
				remote.engines?.number?:0)
	}

	override fun map(remote: LaunchResponse, rocketId: String): Launch {
		return Launch(
				remote.flightNumber,
				rocketId,
				remote.missionName?: "",
				if (remote.launchYear.isNullOrEmpty()) 0 else Integer.valueOf(remote.launchYear),
				remote.launchDateUnix,
				remote.launchSuccess,
				remote.links?.missionPatch
		)
	}
}