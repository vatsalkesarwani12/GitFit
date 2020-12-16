package e.vatsal.kesarwani.gitfit.data.model

import com.google.gson.annotations.SerializedName

class RepoResponse : ArrayList<RepoResponse.RepoResponseItem>() {

    data class RepoResponseItem(
        @SerializedName("id")
        var id: Int? = null,

        @SerializedName("node_id")
        var nodeId: String? = null,

        @SerializedName("name")
        var name: String? = null,

        @SerializedName("full_name")
        var fullName: String? = null,

        @SerializedName("private")
        var `private`: Boolean? = null,

        @SerializedName("owner")
        var owner: Owner? = null,

        @SerializedName("html_url")
        var htmlUrl: String? = null,

        @SerializedName("description")
        var description: String? = null,

        @SerializedName("fork")
        var fork: Boolean? = null,

        @SerializedName("url")
        var url: String? = null,

        @SerializedName("forks_url")
        var forksUrl: String? = null,

        @SerializedName("keys_url")
        var keysUrl: String? = null,

        @SerializedName("collaborators_url")
        var collaboratorsUrl: String? = null,

        @SerializedName("teams_url")
        var teamsUrl: String? = null,

        @SerializedName("hooks_url")
        var hooksUrl: String? = null,

        @SerializedName("issue_events_url")
        var issueEventsUrl: String? = null,

        @SerializedName("events_url")
        var eventsUrl: String? = null,

        @SerializedName("assignees_url")
        var assigneesUrl: String? = null,

        @SerializedName("branches_url")
        var branchesUrl: String? = null,

        @SerializedName("tags_url")
        var tagsUrl: String? = null,

        @SerializedName("blobs_url")
        var blobsUrl: String? = null,

        @SerializedName("git_tags_url")
        var gitTagsUrl: String? = null,

        @SerializedName("git_refs_url")
        var gitRefsUrl: String? = null,

        @SerializedName("trees_url")
        var treesUrl: String? = null,

        @SerializedName("statuses_url")
        var statusesUrl: String? = null,

        @SerializedName("languages_url")
        var languagesUrl: String? = null,

        @SerializedName("stargazers_url")
        var stargazersUrl: String? = null,

        @SerializedName("contributors_url")
        var contributorsUrl: String? = null,

        @SerializedName("subscribers_url")
        var subscribersUrl: String? = null,

        @SerializedName("subscription_url")
        var subscriptionUrl: String? = null,

        @SerializedName("commits_url")
        var commitsUrl: String? = null,

        @SerializedName("git_commits_url")
        var gitCommitsUrl: String? = null,

        @SerializedName("comments_url")
        var commentsUrl: String? = null,

        @SerializedName("issue_comment_url")
        var issueCommentUrl: String? = null,

        @SerializedName("contents_url")
        var contentsUrl: String? = null,

        @SerializedName("compare_url")
        var compareUrl: String? = null,

        @SerializedName("merges_url")
        var mergesUrl: String? = null,

        @SerializedName("archive_url")
        var archiveUrl: String? = null,

        @SerializedName("downloads_url")
        var downloadsUrl: String? = null,

        @SerializedName("issues_url")
        var issuesUrl: String? = null,

        @SerializedName("pulls_url")
        var pullsUrl: String? = null,

        @SerializedName("milestones_url")
        var milestonesUrl: String? = null,

        @SerializedName("notifications_url")
        var notificationsUrl: String? = null,

        @SerializedName("labels_url")
        var labelsUrl: String? = null,

        @SerializedName("releases_url")
        var releasesUrl: String? = null,

        @SerializedName("deployments_url")
        var deploymentsUrl: String? = null,

        @SerializedName("created_at")
        var createdAt: String? = null,

        @SerializedName("updated_at")
        var updatedAt: String? = null,

        @SerializedName("pushed_at")
        var pushedAt: String? = null,

        @SerializedName("git_url")
        var gitUrl: String? = null,

        @SerializedName("ssh_url")
        var sshUrl: String? = null,

        @SerializedName("clone_url")
        var cloneUrl: String? = null,

        @SerializedName("svn_url")
        var svnUrl: String? = null,

        @SerializedName("homepage")
        var homepage: String? = null,

        @SerializedName("size")
        var size: Int? = null,

        @SerializedName("stargazers_count")
        var stargazersCount: Int? = null,

        @SerializedName("watchers_count")
        var watchersCount: Int? = null,

        @SerializedName("language")
        var language: String? = null,

        @SerializedName("has_issues")
        var hasIssues: Boolean? = null,

        @SerializedName("has_projects")
        var hasProjects: Boolean? = null,

        @SerializedName("has_downloads")
        var hasDownloads: Boolean? = null,

        @SerializedName("has_wiki")
        var hasWiki: Boolean? = null,

        @SerializedName("has_pages")
        var hasPages: Boolean? = null,

        @SerializedName("forks_count")
        var forksCount: Int? = null,

        @SerializedName("mirror_url")
        var mirrorUrl: String? = null,

        @SerializedName("archived")
        var archived: Boolean? = null,

        @SerializedName("disabled")
        var disabled: Boolean? = null,

        @SerializedName("open_issues_count")
        var openIssuesCount: Int? = null,

        @SerializedName("license")
        var license: License? = null,

        @SerializedName("forks")
        var forks: Int? = null,

        @SerializedName("open_issues")
        var openIssues: Int? = null,

        @SerializedName("watchers")
        var watchers: Int? = null,

        @SerializedName("default_branch")
        var defaultBranch: String? = null

    ) {

        data class Owner(

            @SerializedName("login")
            var login: String? = null,

            @SerializedName("id")
            var id: Int? = null,

            @SerializedName("node_id")
            var nodeId: String? = null,

            @SerializedName("avatar_url")
            var avatarUrl: String? = null,

            @SerializedName("gravatar_id")
            var gravatarId: String? = null,

            @SerializedName("url")
            var url: String? = null,

            @SerializedName("html_url")
            var htmlUrl: String? = null,

            @SerializedName("followers_url")
            var followersUrl: String? = null,

            @SerializedName("following_url")
            var followingUrl: String? = null,

            @SerializedName("gists_url")
            var gistsUrl: String? = null,

            @SerializedName("starred_url")
            var starredUrl: String? = null,

            @SerializedName("subscriptions_url")
            var subscriptionsUrl: String? = null,

            @SerializedName("organizations_url")
            var organizationsUrl: String? = null,

            @SerializedName("repos_url")
            var reposUrl: String? = null,

            @SerializedName("events_url")
            var eventsUrl: String? = null,

            @SerializedName("received_events_url")
            var receivedEventsUrl: String? = null,

            @SerializedName("type")
            var type: String? = null,

            @SerializedName("site_admin")
            var siteAdmin: Boolean? = null

        )

        data class License(

            @SerializedName("key")
            var key: String? = null,

            @SerializedName("name")
            var name: String? = null,

            @SerializedName("spdx_id")
            var spdxId: String? = null,

            @SerializedName("url")
            var url: String? = null,

            @SerializedName("node_id")
            var nodeId: String? = null
        )
    }
}