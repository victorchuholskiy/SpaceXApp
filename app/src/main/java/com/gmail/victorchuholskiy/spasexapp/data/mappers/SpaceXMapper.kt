package  com.gmail.victorchuholskiy.spasexapp.data.mappers

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.LaunchResponse
import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.RocketResponse

interface SpaceXMapper {
	fun map(remote: RocketResponse): Rocket

	fun map(remote: LaunchResponse, rocketId: String): Launch
}