package kl.socialnetwork.services;

import java.util.concurrent.CompletableFuture;
import kl.socialnetwork.domain.models.bindingModels.comment.CommentCreateBindingModel;

public interface CommentService {
    boolean createComment(CommentCreateBindingModel commentCreateBindingModel) throws Exception;

    CompletableFuture<Boolean> deleteComment(String loggedInUserId, String commentToRemoveId) throws Exception;
}
