<?php

use Symfony\Component\Security\Http\Event\LoginSuccessEvent;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\User\UserInterface;

// Create a new LoginSuccessEvent instance
$event = new LoginSuccessEvent($token = $this->createMock(TokenInterface::class), $request = $this->createMock('Symfony\Component\HttpFoundation\Request'));

// Assume UserInterface implementation
$user = $this->createMock(UserInterface::class);

// Assume token has a method to get user
$token->expects($this->any())
    ->method('getUser')
    ->willReturn($user);

// Create mock request
$request->expects($this->any())
    ->method('getSession')
    ->willReturn($this->createMock('Symfony\Component\HttpFoundation\Session\SessionInterface'));

// Dispatch the event
$dispatcher = $this->createMock('Symfony\Component\EventDispatcher\EventDispatcherInterface');
$dispatcher->expects($this->once())
    ->method('dispatch')
    ->with($event);

$dispatcher->dispatch($event);

// Assert event dispatched
$this->assertInstanceOf(LoginSuccessEvent::class, $event);



<?php

use Symfony\Component\Security\Http\Event\LoginSuccessEvent;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\User\UserInterface;

class LoginSuccessListener 
{
    public function onLoginSuccess(LoginSuccessEvent $event) 
    {
        // Handle the successful login event here
    }
}