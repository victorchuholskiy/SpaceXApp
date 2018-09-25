package  com.gmail.victorchuholskiy.spasexapp.data.mappers

import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import com.gmail.victorchuholskiy.spasexapp.data.entities.remote.response.RocketResponse

interface RocketMapper {
	fun map(remote: RocketResponse): Rocket
}