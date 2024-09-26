<?php

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class UserEditType extends AbstractType {
    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
                ->add('enabled', 'choice', array(
                    'choices' => array('Yes' => 'Yes', 'No' => 'No'),
                    'expanded' => true,
                    'multiple' => false,
                    'label' => 'Enabled: ',
                ))
                ->add('fname')
                ->add('sname')
                ->add('email')
                ->add('username')
                ->add('role', 'choice', array(
                    'choices' => array('ROLE_USER' => 'User', 'ROLE_ADMIN' => 'Admin'),
                    'expanded' => true,
                    'multiple' => false,
                    'label' => 'Group: ',
                ))
        ;
    }

    public function setDefaultOptions(OptionsResolverInterface $resolver) {
        $resolver->setDefaults(array(
            'data_class' => 'Mana\ClientBundle\Entity\User',
            'validation_groups' => array('edit'),
        ));
    }
}