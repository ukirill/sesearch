package com.sesearch.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sesearch.utils.UnixTimestampDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    @JsonProperty("tags")
    public List<String> tags = null;
    @JsonProperty("owner")
    public Owner owner;
    @JsonProperty("is_answered")
    public Boolean isAnswered;
    @JsonProperty("view_count")
    public Integer viewCount;
    @JsonProperty("answer_count")
    public Integer answerCount;
    @JsonProperty("score")
    public Integer score;
    @JsonProperty("last_activity_date")
    public Long lastActivityDate;

    @JsonProperty("creation_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    public Date creationDate;

    @JsonProperty("last_edit_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    public Date lastEditDate;

    @JsonProperty("closed_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    public Date closedDate;

    @JsonProperty("question_id")
    public Integer questionId;
    @JsonProperty("link")
    public String link;
    @JsonProperty("title")
    public String title;
    @JsonProperty("accepted_answer_id")
    public Integer acceptedAnswerId;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(Boolean answered) {
        isAnswered = answered;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Long lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }
}
