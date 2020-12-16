package e.vatsal.kesarwani.gitfit.data.model

import com.google.gson.annotations.SerializedName

class RepoResponse : ArrayList<RepoResponse.RepoResponseItem>() {

    data class RepoResponseItem(
        @SerializedName("id")
        var id: Int?,

        @SerializedName("node_id")
        var nodeId: String?,

        @SerializedName("name")
        var name: String?,

        @SerializedName("full_name")
        var fullName: String?,

        @SerializedName("private")
        var `private`: Boolean?,

        @SerializedName("owner")
        var owner: Owner?,

        @SerializedName("html_url")
        var htmlUrl: String?,

        @SerializedName("description")
        var description: String?,

        @SerializedName("fork")
        var fork: Boolean?,

        @SerializedName("url")
        var url: String?,

        @SerializedName("forks_url")
        var forksUrl: String?,

        @SerializedName("keys_url")
        var keysUrl: String?,

        @SerializedName("collaborators_url")
        var collaboratorsUrl: String?,

        @SerializedName("teams_url")
        var teamsUrl: String?,

        @SerializedName("hooks_url")
        var hooksUrl: String?,

        @SerializedName("issue_events_url")
        var issueEventsUrl: String?,

        @SerializedName("events_url")
        var eventsUrl: String?,

        @SerializedName("assignees_url")
        var assigneesUrl: String?,

        @SerializedName("branches_url")
        var branchesUrl: String?,

        @SerializedName("tags_url")
        var tagsUrl: String?,

        @SerializedName("blobs_url")
        var blobsUrl: String?,

        @SerializedName("git_tags_url")
        var gitTagsUrl: String?,

        @SerializedName("git_refs_url")
        var gitRefsUrl: String?,

        @SerializedName("trees_url")
        var treesUrl: String?,

        @SerializedName("statuses_url")
        var statusesUrl: String?,

        @SerializedName("languages_url")
        var languagesUrl: String?,

        @SerializedName("stargazers_url")
        var stargazersUrl: String?,

        @SerializedName("contributors_url")
        var contributorsUrl: String?,

        @SerializedName("subscribers_url")
        var subscribersUrl: String?,

        @SerializedName("subscription_url")
        var subscriptionUrl: String?,

        @SerializedName("commits_url")
        var commitsUrl: String?,

        @SerializedName("git_commits_url")
        var gitCommitsUrl: String?,

        @SerializedName("comments_url")
        var commentsUrl: String?,

        @SerializedName("issue_comment_url")
        var issueCommentUrl: String?,

        @SerializedName("contents_url")
        var contentsUrl: String?,

        @SerializedName("compare_url")
        var compareUrl: String?,

        @SerializedName("merges_url")
        var mergesUrl: String?,

        @SerializedName("archive_url")
        var archiveUrl: String?,

        @SerializedName("downloads_url")
        var downloadsUrl: String?,

        @SerializedName("issues_url")
        var issuesUrl: String?,

        @SerializedName("pulls_url")
        var pullsUrl: String?,

        @SerializedName("milestones_url")
        var milestonesUrl: String?,

        @SerializedName("notifications_url")
        var notificationsUrl: String?,

        @SerializedName("labels_url")
        var labelsUrl: String?,

        @SerializedName("releases_url")
        var releasesUrl: String?,

        @SerializedName("deployments_url")
        var deploymentsUrl: String?,

        @SerializedName("created_at")
        var createdAt: String?,

        @SerializedName("updated_at")
        var updatedAt: String?,

        @SerializedName("pushed_at")
        var pushedAt: String?,

        @SerializedName("git_url")
        var gitUrl: String?,

        @SerializedName("ssh_url")
        var sshUrl: String?,

        @SerializedName("clone_url")
        var cloneUrl: String?,

        @SerializedName("svn_url")
        var svnUrl: String?,

        @SerializedName("homepage")
        var homepage: String?,

        @SerializedName("size")
        var size: Int?,

        @SerializedName("stargazers_count")
        var stargazersCount: Int?,

        @SerializedName("watchers_count")
        var watchersCount: Int?,

        @SerializedName("language")
        var language: String?,

        @SerializedName("has_issues")
        var hasIssues: Boolean?,

        @SerializedName("has_projects")
        var hasProjects: Boolean?,

        @SerializedName("has_downloads")
        var hasDownloads: Boolean?,

        @SerializedName("has_wiki")
        var hasWiki: Boolean?,

        @SerializedName("has_pages")
        var hasPages: Boolean?,

        @SerializedName("forks_count")
        var forksCount: Int?,

        @SerializedName("mirror_url")
        var mirrorUrl: String?,

        @SerializedName("archived")
        var archived: Boolean?,

        @SerializedName("disabled")
        var disabled: Boolean?,

        @SerializedName("open_issues_count")
        var openIssuesCount: Int?,

        @SerializedName("license")
        var license: License?,

        @SerializedName("forks")
        var forks: Int?,

        @SerializedName("open_issues")
        var openIssues: Int?,

        @SerializedName("watchers")
        var watchers: Int?,

        @SerializedName("default_branch")
        var defaultBranch: String?

    ) {

        data class Owner(

            @SerializedName("login")
            var login: String?,

            @SerializedName("id")
            var id: Int?,

            @SerializedName("node_id")
            var nodeId: String?,

            @SerializedName("avatar_url")
            var avatarUrl: String?,

            @SerializedName("gravatar_id")
            var gravatarId: String?,

            @SerializedName("url")
            var url: String?,

            @SerializedName("html_url")
            var htmlUrl: String?,

            @SerializedName("followers_url")
            var followersUrl: String?,

            @SerializedName("following_url")
            var followingUrl: String?,

            @SerializedName("gists_url")
            var gistsUrl: String?,

            @SerializedName("starred_url")
            var starredUrl: String?,

            @SerializedName("subscriptions_url")
            var subscriptionsUrl: String?,

            @SerializedName("organizations_url")
            var organizationsUrl: String?,

            @SerializedName("repos_url")
            var reposUrl: String?,

            @SerializedName("events_url")
            var eventsUrl: String?,

            @SerializedName("received_events_url")
            var receivedEventsUrl: String?,

            @SerializedName("type")
            var type: String?,

            @SerializedName("site_admin")
            var siteAdmin: Boolean?

        )

        data class License(

            @SerializedName("key")
            var key: String?,

            @SerializedName("name")
            var name: String?,

            @SerializedName("spdx_id")
            var spdxId: String?,

            @SerializedName("url")
            var url: String?,

            @SerializedName("node_id")
            var nodeId: String?
        )
    }
}