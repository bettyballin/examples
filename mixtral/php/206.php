<?php
    echo CHtml::beginForm();
    echo CHtml::activeHiddenField($model, 'id');
    // other form fields
?>

    <div class="row buttons">
        <?= CHtml::submitButton('Submit', array('class' => 'btn btn-primary')); ?>
    </div>
<?php echo CHtml::endForm(); ?>