package de.byteleaf.companyon.timelog.boundary

import de.byteleaf.companyon.timelog.access.TimeLogAccessService
import de.byteleaf.companyon.timelog.dto.TimeLog
import de.byteleaf.companyon.timelog.dto.TimeLogInput
import de.byteleaf.companyon.timelog.dto.TimeLogUpdate
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.kickstart.tools.GraphQLSubscriptionResolver
import org.reactivestreams.Publisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import java.time.OffsetDateTime

@Controller
class TimeLogResolver : GraphQLQueryResolver, GraphQLMutationResolver, GraphQLSubscriptionResolver {

    @Autowired
    private lateinit var timeLogAccessService: TimeLogAccessService

    fun timeLogs(from: OffsetDateTime?, to: OffsetDateTime?, userId: String?, projectId: String?): List<TimeLog> = timeLogAccessService.findTimeLogs(from, to, userId, projectId)

    fun createTimeLog(input: TimeLogInput): TimeLog = timeLogAccessService.create(input)

    fun deleteTimeLog(id: String): TimeLog = timeLogAccessService.delete(id)

    fun updateTimeLog(id: String, input: TimeLogInput): TimeLog = timeLogAccessService.update(id, input)

    fun timeLogUpdate(): Publisher<TimeLogUpdate> = timeLogAccessService.getPublisher()
}