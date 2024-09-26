if ($payment_intent->status === "requires_action" &&
    $payment_intent->next_action->type === 'redirect_to_url') {
  header('Location: ' . $payment_intent->next_action->redirect_to_url->url);
  exit;
}